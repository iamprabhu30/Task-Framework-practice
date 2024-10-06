Feature: Search and place the order
@TC01
Scenario Outline: User view the greenkart page and place the searched order

Given user land on green kart page
When user searched the product name <shortname> and extracted the actual name
Then user searched the same name <shortname> in offers page
And user validate product name in offer page with landing page


Examples:
|shortname|
|tom|
|beans|
#|pot|


