Make sure you provide the name of the input text file without its extension as an command-line arguments.
Please enter at most one fiel name as argument to the jar file. If you don't; it will work properly for the first one, but after that it will try to combine first and second, and so on...

INPUTFILE FORMAT: (If there is more than one element at a line, seperate them by 'space')
NumberOfCities(N1)
NameOfCities(A, B, C ...)
NumberOfRoutes(N2)
Route1
Route2
...
RouteN2(For every route CityFrom, CityTo, Time)
Question(Start and End cities)
