import webcrawler
import web_file_operations
import re
import sys
import time

#  This is the main function used to control the ESO forum Webcrawling program
#  This controls iteration of the webcrawler function calls
#
#  A Web_file_operations object, called main_file_handler, is created to load saved data
#  From previous runs of the program.
#
#  A webcrawler object, called crawler,  is instantiated and used to store download queue information
#  If no queue information is loaded, then the seed url is used to generate the initial need_to_download_queue
#
#  configurable items that adjust program behavior are stored in the "Configurable Options" section

def main():
    print ("Welcome to ESO forum web crawling program!")
    
    # -----------------------------------------------------------------------
    #  Configurable options
    #
    #
    #
    outfile='eso_comments.csv'
    url_seed='https://forums.elderscrollsonline.com/en'
    url_seed_minus_language_tag='https://forums.elderscrollsonline.com'
    url_discussion_seed='https://forums.elderscrollsonline.com/en/discussion/'
    url= url_seed
    regex_urls_to_ignore=re.compile('(?:(https:\/\/forums\.elderscrollsonline\.com\/en\/)|(\/en\/))((entry\/.*?)|(post\/.*?)|(profile.*?)|(discussion\/((staff\/.*?)|(comment.*?))))$')
    downloaded_urls_file='downloaded.txt'
    save_file_for_need_to_download_queue='need_to_download_pickle'
    # end configurable options
    # ---------------------------------------------------------------------
    #
    main_file_handler=web_file_operations.web_file_operations(outfile)
    if main_file_handler.load_need_to_download_queue_from_disk(save_file_for_need_to_download_queue):
        need_to_download_queue=main_file_handler.load_need_to_download_queue_from_disk(save_file_for_need_to_download_queue)
    else:  
        need_to_download_queue=[]
        need_to_download_queue.append(url)
    
    
    file_handler=web_file_operations.web_file_operations(outfile)
    url_downloaded_queue=file_handler.func_parse_download_file_for_sites(downloaded_urls_file)
    crawler=webcrawler.WebCrawler(url_seed,url_seed_minus_language_tag,url_discussion_seed,regex_urls_to_ignore,url_downloaded_queue,need_to_download_queue,outfile,downloaded_urls_file,save_file_for_need_to_download_queue)
    crawler.func_bs4_find_urls_on_page(crawler.func_download_page(crawler.need_to_download_queue.pop()))#initiates the search by popping item off queue

    #main loop
    #This controls iteration through the webcrawler.  
    #Essentially, this runs until the need_to_download_queue is empty
    while crawler.need_to_download_queue:
        for url_to_download in crawler.need_to_download_queue:
            try:
                print ('Checking: '+str(url_to_download.encode("utf-8"))+'')
            except:
                print('Error printing url', sys.exc_info()[0], sys.exc_info()[1])
            #print (url_to_download)
            try:
                downloaded=crawler.func_download_page(url_to_download)
            except:
                print('Error calling func_download_page in loop', sys.exc_info()[0], sys.exc_info()[1])
            try:
                if downloaded:#check if a file was downloaded.  Will be none for bad urls
                    crawler.func_bs4_find_urls_on_page(downloaded)
            except:
                print('Error calling func_find_urls_on_page in loop', sys.exc_info()[0], sys.exc_info()[1])
            time.sleep(.10)#short sleep
    
        #crawler.func_export_download_manifest_with_shelve()
    print ('Program complete!')
if __name__ == "__main__":    
        main()
        
        
        
        
        
        
        
        
        