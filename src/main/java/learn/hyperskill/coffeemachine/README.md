Project: Coffee Machine
-----------------------

### State 5 of 6: On a coffee loop

#### Description
But just one action isn’t interesting. Let's improve the program so it can do multiple actions, 
one after another. The program should repeatedly ask what the user wants to do. 
If the user types "buy", "fill" or "take", then just do what the program did in the previous step. 
However, if the user wants to switch off the coffee machine, he should type "exit". 
Then the program should terminate. Also, when the user types "remaining", 
the program should output all the resources that the coffee machine has.

Also, do not forget that you can be out of resources for making coffee. 
If the coffee machine doesn’t have enough resources to make coffee, the program should 
output a message that says it can't make a cup of coffee.

And the last improvement to the program at this step—if the user types "buy" to buy a cup of coffee 
and then changes his mind, he should be able to type "back" to return into the main cycle.

Remember, that:
* For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
* For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
* And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.

#### Instruction
Write a program that will work endlessly to make coffee for all interested persons 
until the shutdown signal is given.


### Stage 4 of 6: Action!

#### Description
Let's simulate an actual coffee machine. 
It has a limited supply of water, milk, coffee beans, and disposable cups. 
Also, it counts how much money it gets for selling coffee. 
The coffee machine has several options:  
__first__, it needs to be able to sell coffee. 
It can make different varieties of coffee: espresso, latte, and cappuccino. 
Of course, each variety requires a different amount of supplies, 
except that all of them require only one disposable cup.  
__Second__, the coffee machine should be able to get replenished by a special worker.  
__Third__, another special worker should be able to take money from the coffee machine.

Write the program that can do one of these actions at a time. 
It reads one line from standard input, which can be "buy", "fill", "take". 
If you want to buy some coffee, input "buy". 
If you are a special worker and you think that it is time to fill out all the supplies 
for the coffee machine, input "fill". 
If you are another special worker and it is time to take the money from the coffee machine, 
input "take".

If the user writes "buy" then they must choose one of three varieties of coffee 
that the coffee machine can make: espresso, latte, or cappuccino.

* For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
* For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
* And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.

If the user writes "fill", the program should ask them how much water, milk, coffee, 
and how many disposable cups they want to add to the coffee machine.

If the user writes "take" the program should give them all the money that it earned from selling coffee.

At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, 
and 9 disposable cups.

Write the program that prints the coffee machine’s state, processes one query from the user, 
and also prints the coffee machine’s state after that. 
Try to use methods to implement every action that the coffee machine can do.

#### Instruction
Write a program that offers to buy one cup of coffee or to fill the ingredients or to take its money. 
At the same time, the program should calculate how many ingredients it has left. 
And also display the number of ingredients before and after purchase.
