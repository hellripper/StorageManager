/* 
	@ author: Penchala Sainath Rachaputi
	@ date  : febuary 2016
	@ Description : Implementation of storage manager.
*/

// include all the required header files for the program
#include "storage_mgr.h"
#include "dberror.h"
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include  <sys/stat.h>

/* manipulating page files */

void initStorageManager (void){
//We don't have any global data structures to initialise.
}

/*  Method: Create Page File : We Check if the file already exists. If the file exists, we return an error message syaing that the file is already exists. 
    		If the file doesn' t exist, then we create the file and allocate the size of one PAGE to it. */
    		
RC createPageFile (char *fileName){
    int k;
    // Creaing the file in binary format
    FILE *filep;
    filep=fopen(fileName,"wb"); 
    
    //Writing a file with 0's
	for(k=0; k<PAGE_SIZE; k++){
		fprintf(filep,"%c",'\0'); 
	}
	
	// close the file		
	fclose(filep);
    return RC_OK;
}

/* Method: Open Page File : We first check if the file with the given name exists or no. Then, If it doesn't exist, we return an error message. 
							If the file exists, we check the total number of pages that the file has and store it in page number object. 
							Also, after we open the file, we initiate the structure elements that are needed.*/
							
RC openPageFile (char *fileName, SM_FileHandle *fHandle){
    FILE *filep;
    //Checking if the file exists or not
    if(access(fileName, F_OK)!=-1){
    	// open file
        filep = fopen(fileName,"rb+"); 
        // handling the exceptions
        if(filep==NULL){
            return RC_FILE_NOT_FOUND;
        }
        
        //Calculate the size of the file
        struct stat st;
        if (stat(fileName, &st) == 0)
        {
            unsigned long int numberOfPageBlocks;
            numberOfPageBlocks = (st.st_size)/PAGE_SIZE;
            if((st.st_size)%PAGE_SIZE > 0)
            	fHandle->totalNumPages = numberOfPageBlocks+1;
            else
            	fHandle->totalNumPages = numberOfPageBlocks;
        }
        // returning the file properties
        fHandle->fileName=fileName;
        fHandle->curPagePos=0;
        fHandle->mgmtInfo = filep;
        return RC_OK;
    }
    else{
    	// handling the exceptions
        return RC_FILE_NOT_FOUND; 
    }
}

/*  Method : Close Page File : We close the file and return a success message if success i.e RC_OK 
			and if the file couldn't be located, we return RC_FILE_NOT_FOUND error message. */
			
RC closePageFile(SM_FileHandle *fHandle) {
	// handling file init exception if null 
    if(fHandle==NULL){
        return RC_FILE_HANDLE_NOT_INIT;
    }
	
	// closing the file 
    FILE *fp = fHandle->mgmtInfo;
    fclose(fp);
    return RC_OK;
}


/*  Function : Destroy Page File : We first check if the file is present or no, if it exists we remove the file. 
			  Upon success, return a success message. Upon failure, return a failure message.*/

RC destroyPageFile (char *fileName){
	// if File found then delete
    if(remove(fileName)==0){
        return RC_OK;
    }
    // handling the exceptions
    else{
        return RC_FILE_NOT_FOUND; 
    }
}



/* reading blocks from disc */

/* 	Method : Read Block : We first check if the file is present or no. 
						  If it exists we move the position of the file descriptor to the page requested in page number.*/
RC readBlock(int pageNum, SM_FileHandle *fHandle, SM_PageHandle memPage)
{	
	// handling all the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	if (memPage == NULL)
		return RC_READ_NON_EXISTING_PAGE;
	if (pageNum >= fHandle->totalNumPages)
		return RC_READ_NON_EXISTING_PAGE;
	if (pageNum < 0)
		return RC_READ_NON_EXISTING_PAGE;
	if (fHandle->mgmtInfo == NULL)
		return RC_FILE_NOT_FOUND;
		
		// point the file 
        fseek(fHandle->mgmtInfo,PAGE_SIZE*(pageNum-1),SEEK_SET);
        //Reading the content to memPage.
        fread(memPage,PAGE_SIZE,1,fHandle->mgmtInfo);
        // set page number
		fHandle->curPagePos=pageNum;
    return RC_OK;
}


/* Method : Get Block Pos: This method is used to get the current block position at that instant */
int getBlockPos (SM_FileHandle *fHandle)
{
	// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	return fHandle->curPagePos;
}



/* Method : Read Last Block: Read last page of the file.*/
RC readLastBlock (SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	return readBlock(fHandle->totalNumPages,fHandle,memPage);
}



/* Method : Read First Block: This methos is used to Read first block of the file.*/
RC readFirstBlock (SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	return readBlock(0,fHandle,memPage);
}

/* Method : Read Next Block : This Method is used to read the next block*/
RC readNextBlock (SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	return readBlock(fHandle->curPagePos+1,fHandle,memPage);
}

/* Method : Read Current Block: This method is used for reading current block*/
RC readCurrentBlock (SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	return readBlock(fHandle->curPagePos,fHandle,memPage);
}

/* Method : Read Previous Block: This method is used to read the previos block*/
RC readPreviousBlock (SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	/// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	return readBlock(fHandle->curPagePos-1,fHandle,memPage);
}


/* Method : Append Empty Block : We add one page and print'\0' in the empty block. */
 RC appendEmptyBlock (SM_FileHandle *fHandle){
    int k;
    // handling the exceptions
	if(fHandle->mgmtInfo!=NULL){	
		// adding new block and appending with 0's
        for(k=0; k<PAGE_SIZE; k++){
            fprintf(fHandle->mgmtInfo,"%c",'\0'); 
        }
        return RC_OK;
	}
	else{
		// handling the exceptions
        return RC_FILE_NOT_FOUND;//We return RC_FILE_NOT_FOUND if the file is not found.
	}
}

/* Method : Write Block : we write the contents to the file and then close the file.*/
RC writeBlock(int pageNum, SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	// handling the exceptions
    if(NULL == fHandle->mgmtInfo||pageNum > fHandle->totalNumPages)
    {
        return RC_FILE_HANDLE_NOT_INIT;
    }
    // get current position and write the contents of the file
    fseek(fHandle->mgmtInfo,PAGE_SIZE * pageNum ,0);
    fwrite(memPage,PAGE_SIZE,1,fHandle->mgmtInfo); 
    return RC_OK;
}

/* Method : Write Current Block : We first check if the file is present or no and if it exists we write the current block based on absolute position. */
RC writeCurrentBlock (SM_FileHandle *fHandle, SM_PageHandle memPage)
{
	// handling the exceptions
	if (fHandle == NULL)
		return RC_READ_NON_EXISTING_PAGE;
	return writeBlock(fHandle->curPagePos,fHandle, memPage);
}


/* Method : Ensure Capacity : If the file's memory is not sufficient we calculate the space needed to make sure that the file has enough capacity and allocate the same memory.*/
RC ensureCapacity (int numberOfPages, SM_FileHandle *fHandle)
{	
	// handling the exceptions
	if (fHandle == NULL)
		return RC_FILE_HANDLE_NOT_INIT;
	// append empty block if total pages are less than required pages
	while(fHandle->totalNumPages < numberOfPages)
	{
		if (appendEmptyBlock(fHandle) != RC_OK)
			return RC_WRITE_FAILED;
	}
	return RC_OK;
}

