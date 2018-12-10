-module('ServiceConfigurator').

-export([addFilter/1, removeAllFilters/0, addPrinter/1, removeAllPrinters/0]).

addFilter(Filter) ->
    'FiltersProvider':add(Filter).

removeAllFilters() ->
    'FiltersProvider':removeAll().

addPrinter(Printer) ->
    'PrintersProvider':add(Printer).

removeAllPrinters() ->
    'PrintersProvider':removeAll().
