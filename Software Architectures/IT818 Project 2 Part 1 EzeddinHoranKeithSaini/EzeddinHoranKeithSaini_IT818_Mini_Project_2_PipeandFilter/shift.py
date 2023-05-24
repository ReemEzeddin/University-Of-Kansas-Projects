#from time import process_time
#t1_start = process_time()
#split string
with open ("input_data.txt", "r", encoding="utf-8", errors="ignore") as myfile:
    for str in myfile:
        splits = str.split()
#iterate over each variation
        for split in splits:
            splits=splits[-1:]+splits[:-1]
            print(" ".join(splits))
#t1_stop = process_time()
#print("Elapsed time during the whole program in seconds:", t1_stop-t1_start)
