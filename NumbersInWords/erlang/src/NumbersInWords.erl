%%%-------------------------------------------------------------------
%%% @author Amado Elga <rosemary@scuba>
%%% @copyright (C) 2018, Amado Elga
%%% @doc
%%%
%%% @end
%%% Created : 17 Dec 2018 by Amado Elga <rosemary@scuba>
%%%-------------------------------------------------------------------
-module('NumbersInWords').

-export([inWords/1]).

inWords(Input) when 0 < Input  ->
    Input.
