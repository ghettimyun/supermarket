# tdp software craftsmanship workshop //
## Kata01: Supermarket Pricing

### intro - 5m
brief us stuff
or should c1/tdp heavy stuff go here, 15 min?

### overview - 5m
where we talk about supermarket pricing
and some of the concerns that can be practiced with tdd
describe kata - https://www.youtube.com/watch?v=auavC2MGnMU

#### system requirements - 10m
where we describe the system requirments for practicing the exercise
##### install an ide
https://www.eclipse.org/downloads/eclipse-packages/
https://www.jetbrains.com/idea/download/
##### github account
https://github.com/join?source=header-home
##### fork repo
or clone, or download zip if skipping travis/git
https://github.com/automaticgiant/supermarketcraft

#### acceptance criteria - 5m
where we describe the initial requirements required to exercise the driver

### base
line item (interface): unit price, unit(default: pkg), desc, qty
enum: normal, nx, bogo, discount
idk - something that we can do control interface so driver can run some transactions wiht it but cover some of the pricing options

### feature 1: nx saleType - 10m
feature branch
#### write a test
watch it fail
#### write some code
make it pass
satisfies subtotal 1
commit/merge

### hook up travis - 2m
https://travis-ci.org/
talk about ci (don't forget to run tests, check pr automatically, don't build on broken code, history)
talk about test coverage benefits (prevent brittle code, catch regressions, frees you to iterate, facilitates teamwork)

### feature 2: bogo - 10m
feature branch
#### write a test
watch it fail
#### write some code
make it pass
commit/merge

## bad code
examples
smells
naming conventions

## refactoring


# links
- [kata](http://codekata.com/kata/codekata-intro/)
- [kata backstory](http://codekata.com/kata/codekata-how-it-started/)
- [supermarket exercise](http://codekata.com/kata/kata01-supermarket-pricing/)

