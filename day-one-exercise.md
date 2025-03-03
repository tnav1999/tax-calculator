# Day one exercise

## Given this context

- The tax model will be configured from a file located in the project's resource folder.
- The content of the tax model is defined below
- By examining the range of a given income, we can determine the applicable tax rate from the tax model. The tax amount can then be calculated using the formula: **income * tax rate**.

## Personal income tax model

```json
[
    {
        "index": 1,
        "upTo": 5000000,
        "rate": 0.05
    },
    {
        "index": 2,
        "upTo": 10000000,
        "rate": 0.1
    },
    {
        "index": 3,
        "upTo": 18000000,
        "rate": 0.15
    },
    {
        "index": 4,
        "upTo": 32000000,
        "rate": 0.20
    },
    {
        "index": 5,
        "upTo": 52000000,
        "rate": 0.25
    }
]
```

## Requirements

- Implement an API to get the current personal income tax model
- Implement an API to calculate the personal income tax for the inputted income
  - The inputted income must be validated before use for calculation
    - Must not be empty
    - Must be positive number
  - The response must contains:
    - The amount of tax
    - The applied tax rate