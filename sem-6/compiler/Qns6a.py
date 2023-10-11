#realization of code motion technique for loop optimization
import time

b = 1; d = 2; e = 3; g = 4; h = 5 

def un_optimized():

    start_time = time.time();

    for i in range(100000000):
        a = b + i
        c = d + e
        f = g + h

    end_time = time.time();

    return (end_time - start_time)

def optimized():

    start_time = time.time();

    c = d + e
    f = g + h

    for i in range(100000000):
        a = b + i
        
    end_time = time.time();

    return (end_time - start_time)

print(f'time taken by un-optimized code : {un_optimized()} seconds\ntime taken by optimized code : {optimized()} seconds.')

