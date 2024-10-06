Feature: Search and place the order
@TC01
Scenario Outline: User view the greenkart page and place the searched order

Given user land on green kart page
When user searched the product name <shortname> and extracted the actual name
Then user click on add to cart
And user click on Place order
And user select the "<country>" and click on proceed


Examples:
|shortname|	country	|
|tom			|	India		|
#|beans		|India		|	
#|pot|


