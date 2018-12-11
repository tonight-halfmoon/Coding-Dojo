-module('FiltersProvider').

-export([add/1, removeAll/0, filters/0]).

add(Filter) ->
    'ServiceProvider':add(Filter, ?MODULE).

removeAll() ->
    'ServiceProvider':removeAll(?MODULE).

filters() ->
    'ServiceProvider':services(?MODULE).
