Feature:  Credit Assessment Calculator  This is a simple credit assessment calculator feature

Scenario Outline: Calculate Credit Assessment Score
When The calculateCreditAssessmentScore API is called with <numberOfEmployees>, <companyType>, <numberOfYearsOperated> parameters
Then The credit assessment score should match <creditScore>

Examples:
    | numberOfEmployees | companyType                 | numberOfYearsOperated | creditScore |
    | 6                 | "Sole Proprietorship"       | 5                     | 7           |
    | 10                | "Limited Liability Company" | 8                     | 13          |