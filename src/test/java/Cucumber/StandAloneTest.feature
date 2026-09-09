@tag
Feature: Purchase the order from Ecommerce website 
	I want to use this template for my feature file
	
	Background:
	Given I land on Ecommerce page
	
	@tag2 
	Scenario Outline: Positive test of submitting the order
	
		Given Logged in with username <name> and Password <pass>
		When I add product <Productname> to cart
		And  checkout <Productname > and submit the order
		Then "Thankyou for the order." message is displayed on confirmation Page
		
		Examples:
		| name                       | pass      |Productname   |
		| gopinath.k170699@gmail.com |Gopi123456 |ZARA COAT 3   |
