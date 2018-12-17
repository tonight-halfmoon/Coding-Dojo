# Kata Numbers In Words

## Problem Description
Return the amount of money provided in numbers as words. For example, USD 745 (amount in numbers) as Seven Hundred and Fourty Five U.S. dollars (amount in words).

## Specifications
1. Program does not process input when value of input is less than 1

```
Example: -1 is not processed
```

1.Program does process input when the type of the value of the input is numerical

```
Example: 'three' is not processed
```

1.Program does not process decimal values

```
Example: Input Value 12.3 is a decimcal value
```

1. Program does process input and return as result, if possible, `Numbers in Words` in English language by default


```
Example: Input: 34, Output: "Thirty Four"

```

1. Clients do need to be able to receive results of `Numbers In Words` in chosen languages different than English


```
Examples: Languages choices are German, Japanese and Arabic
```

```
Examples: Language chosen is Japanese, Input: 130, Result: "hyaku san-ju"
```

[hyaku](https://japan-cc.com/images/knmhyaku.gif)
![alt text](https://japan-cc.com/images/knm3.gif)
![alt text](https://japan-cc.com/images/knm10.gif)

1. Client needs to be able to send the result as Json string as payload of some REST API

```
Example: {"AmountInnumbers": 342, "Currency": "USD", "NumbersInWords": "Three Hundred and Fourty Two"}
```