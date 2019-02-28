# AMS_Cardinality_Estimation
This project is an implementation of AMS algorithms for cardinality estimation.

## Aim of this Project
This project's aim is to reduce the memory use when counting the number of distinct elements in streaming data.
With AMS Algorithms, the memory of recording a count of n is reduced from O(logn) to O(log(logn))

## Basic Idea
Imagine the hash function behaves as if it’s a uniform random mapping.

Of the hash values:
* Roughly half are even 
* Roughly half of those are divisible by four 
* Roughly half of those are divisible by eight 
  
And so on... 

If we have 2^k distinct items in a set or stream, then there are roughly:
* 2k^(-1) hash values that are even
* 2k^(-2) hash values divisible by four

... 
* 1 hash value that is divisible by 2^k  

So for this value that is divisible by 2^k but not by 2^(k+1), it would end with 1 and then k zeros in binary. This can be done by Integer.numberOfTrailingZeros() function in Java, let's call it zeros(). 

The estimating part of algorithms is as follow:

```
  Let z be 0 
  For each item x ：
      z ← max{z, zeros(h(x))} 
  Return 2^(z+1/2)
```
The effectiveness is protected by running multiple AMS estimators at same time, then use the value of median as result.
