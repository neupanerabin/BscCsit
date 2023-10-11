#realization of loop jamming technique for loop optimization
import time

def un_optimized():

    start_time = time.time();

    for i in range(100000000):
        a = 5 + i
    for i in range(100000000):
        c = 10 + i

    end_time = time.time();

    return (end_time - start_time)

def optimized():

    start_time = time.time();

    for i in range(100000000):
        a = 5 + i
        c = 10 + i
        
    end_time = time.time();

    return (end_time - start_time)

print(f'time taken by un-optimized code : {un_optimized()} seconds\ntime taken by optimized code : {optimized()} seconds.')

