# Magic number 6174

I created simple java program for magic number 6174.

**In 1949, Indian mathematician, D. R. Kaprekar**, discovered an interesting property of the number 6174, which was subsequently named the Kaprekar constant.
He showed that 6174 is reached in the limit as one repeatedly subtracts the highest and lowest numbers that can be constructed from a set of four digits that are not all identical. Thus, starting with 1234, we have:

4321 − 1234 = 3087, then<br>
8730 − 0378 = 8352, and<br>
8532 − 2358 = 6174.<br>

Further after reading more articles, I see that same can be achieved even
 - if number is having two distinct digits (no need of all 4 distinct digits)
 - if number includes two leading zeros

I added few samples in program that will produce step by step solution.<br>
Example<br>
Processing number: 2323<br>
3322 - 2233 = 1089<br>
9810 - 0189 = 9621<br>
9621 - 1269 = 8352<br>
8532 - 2358 = 6174<br>
7641 - 1467 = 6174<br>

And maintain a list of ignored numbers in case of validation fails.

For more reading below are links:
* https://en.wikipedia.org/wiki/D._R._Kaprekar
* https://en.wikipedia.org/wiki/6174_(number)
