%%%-------------------------------------------------------------------
%%% @author Amado Elga <rosemary@scuba>
%%% @copyright (C) 2018, Amado Elga
%%% @doc
%%%
%%% Kata Numbers In Words
%%% ## Problem Description
%%% Return the amount of money provided in numbers as words. For example, USD 745 (amount in numbers) as Seven Hundred and Fourty Five U.S. dollars (amount in words).
%%%
%%% Specifications:
%%% Program does not process input when value of input is less than 1
%%% Example: -1 is not processed
%%% Program does process input when the type of the value of the input is numerical
%%% Example: 'three' is not processed
%%% Program does not process decimal values
%%% Example: Input Value 12.3 is a decimcal value
%%% Program does process input and return as result, if possible, `Numbers in Words` in English language by default
%%% Example: Input: 34, Output: "Thirty Four"
%%% Clients do need to be able to receive results of `Numbers In Words` in chosen languages different than English
%%% Examples: Languages choices are German, Japanese and Arabic
%%% Examples: Language chosen is Japanese, Input: 130, Result: "hyaku san-ju"
%%%
%%% <P><IMG SRC="https://japan-cc.com/images/knmhyaku.gif" border=0 hspace=5 vspace=5>
%%% <P>100 (<I>hyaku</I>)
%%% <P><IMG SRC="https://japan-cc.com/images/knm3.gif" border=0 hspace=5 vspace=5>
%%% <P><IMG SRC="https://japan-cc.com/images/knm10.gif" border=0 hspace=5 vspace=5>
%%% <P>30 (<I>san-ju</I>)
%%%
%%% Client needs to be able to send the result as Json string as payload of some REST API
%%% Example: {"AmountInnumbers": 342, "Currency": "USD", "NumbersInWords": "Three Hundred and Fourty Two"}
%%% @end
%%% Created : 17 Dec 2018 by Amado Elga <rosemary@scuba>
%%%-------------------------------------------------------------------
-module('NumbersInWords_tests').

-include_lib("eunit/include/eunit.hrl").

inWords_givenLessThan1_thenThrowNumberLessThanOneException_test() ->
    Input = 0,
    ExpectedError = error,
    ExpectedErrorReason = function_clause,

    ActualFun = fun() -> 'NumbersInWords':inWords(Input) end,

    ?assertException(ExpectedError, ExpectedErrorReason, ActualFun()).
