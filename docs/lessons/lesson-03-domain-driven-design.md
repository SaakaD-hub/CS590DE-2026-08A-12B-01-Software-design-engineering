# Lesson 3 – Domain Driven Design: summary

## The core idea (slides 2–17)

- The domain layer is the most important part of the application. Everything else
  (controllers, services, DAOs, plumbing) exists to get requests in and data out.
- Fred Brooks: deciding *what* to build is the hardest part. You have to understand the
  domain before you write code.
- Domain experts, developers and architects each speak their own language. DDD fixes this
  with a **ubiquitous language**: one vocabulary used in conversation, in specs, in tests and
  in the code. `Customer`, `Order`, `ShippingMethod` mean the same thing to everyone.
- A **domain model** is a simplification of reality for the area of interest (the London tube
  map vs. the satellite photo). More complexity → more modelling.
- When the code mirrors the real world: errors are easier to spot, new developers learn the
  domain from the code, tests are easier, no translation layer between business and IT.

## Anemic vs. rich domain model (slides 19–26)

| Anemic (NOT OK)                                  | Rich (OK)                                            |
|--------------------------------------------------|------------------------------------------------------|
| Domain classes are bags of getters/setters       | Domain classes contain the business logic            |
| All logic in `AccountService.withdraw()`         | `Account.withdraw()` computes the balance itself     |
| Service classes grow huge, no single responsibility | Services stay thin: load → call domain → save     |
| Reflects the data structure only                 | Reflects the behaviour of the business               |

Slides 22–25 show the same `withdraw()` twice: anemic (service does `getBalance`,
`setBalance`, `addTransaction`) vs. rich (service calls `account.withdraw()`, the account
does the rest).

## Orchestration vs. choreography (slides 28–31)

- Orchestration = one central brain (conductor, procedural code, waterfall PM, anemic model).
  Easy to follow, does not scale to complex systems.
- Choreography = no central brain (dancers, OO code, agile team, rich model). Harder to
  follow, works well in large/complex systems.
- Key principle 5: orchestration for small/simple scope, choreography for large/complex scope.

## Domain model patterns (slides 33–68)

### Entity
- Has identity; identity stays constant even when attributes change (ID 1 is still Steve
  whether his favourite colour is blue or orange).
- Mutable, has a lifecycle (order placed → paid → fulfilled).
- Examples: Customer, Package, Product.

### Value object
- No identity; equality is based on its attribute values.
- Immutable: no setters, every "change" returns a new instance (`Money.add` returns a new Money).
- Cohesive: groups attributes that belong together (amount + currency, red + green + blue).
- Behaviour rich: `Meters.toYards()`, `isLongerThan()`.
- Self-validating: constructor throws if the state is invalid (negative money).
- Combinable and testable without mocks.
- Static factory methods (`Height.fromFeet(3)`) make construction expressive.
- Replacing `String color` with a `Color` value object gives clarity and built-in validation.
- The seat test: if visitors sit anywhere, Seat is a value object; if the ticket has a seat
  number, Seat is an entity.
- Slide 54: push behaviour out of the fat `Customer` entity into `Contact`, `Address`, `Login`
  value objects. Slide 55: always prefer value objects over entities.

### Domain service
- For behaviour that is a real domain concept but belongs to no single entity or value
  object (`ShippingCostCalculator`, `TransferFundsService`).
- Stateless, no attributes, no identity. Interface defined in terms of other domain objects.
- Different from the *application* service in the service layer: the domain service contains
  only business logic and never talks to plumbing; the service-layer class contains no
  business logic and only talks to plumbing (slide 64).

### Domain event
- Immutable class representing something that already happened: `OrderReceived`,
  `DeliveryFailed`, `ProductAddedEvent`.
- Raised by the domain/service, handled by event handlers that live in the domain or the
  service layer (e.g. `RecommendationService` reacts to `ProductAddedEvent`).

## Key principle 4
The hardest and most important aspect of software development is the domain: create a
domain model, crunch knowledge with the business, put domain logic in its own layer, let it
reflect the real world.
