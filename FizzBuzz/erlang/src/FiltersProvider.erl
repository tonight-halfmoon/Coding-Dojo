-module('FiltersProvider').

-export([addFilter/1, numberOfFilters/0, removeAllFilters/0, filters/0]).

addFilter(Filter) ->
    'ServiceProvider':add(Filter, ?MODULE).

numberOfFilters() ->
    'ServiceProvider':count(?MODULE).

removeAllFilters() ->
    'ServiceProvider':removeAll(?MODULE).

filters() ->
    'ServiceProvider':services(?MODULE).
