# calculator project V0-1
The name of the calculator is mcalc. It is an simple program for command line
calculations.

## Basic Mode
To start mcalc in basic mode you just type mcalc in your command

In basic mode it will take arguments in the form:
  integer "operator" integer ...
The first version will include the operators:
  "+", "-", and "\*"
  
If a newline is added and the opartion read in is viable
it will output the result and leave mcalc
Else it will write all the viable parts of the typed in information and prompt
you to enter an correct statement.
To exit mcalc just type newline on an empty line or (e,exit,q,quit)

## Argument Mode
To start mcalc in Argument Mode you just type mcalc "arg1" "arg2" etc into
the command line.
If you add arguments to mcalc in the form of mcalc "arg1" "arg2" ...
mcalc will check if you typed an viable operation.
If yes, it will directly print the result
else it will switch to basic mode.
