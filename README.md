
# Credit Score Calculator Service

**Table of Contents**

- Usage
- Prerequisites
- Build
- Application Start Up

## Usage
- Provide interface to calculate credit score of a company
- Extendable Credit Calculator Service 

## Prerequisites
Following platform is required to run the application:
- Java JDK 1.8
- Postman (Optional)

## Build

You may build the project with following command

```bash
mvn clean install
```

## Application Start Up
**To Start the Server for development:**
1. Open console window (eg: windows command prompt / Mac OS terminal)
2. Direct to  project folder 
3. Execute following command 

	java -jar target\calculator-0.0.1-SNAPSHOT.jar

## How to Use
**Sample request**: 

```bash
{
  "numberOfEmployees":6,
  "companyType": "Sole Proprietorship",
  "numberOfYearsOperated": 5
}
```

**URL**:

```bash
http://localhost:8080/creditservice/v1/calculator
```

**Sample response**: 

```bash
{
    "creditScore": 7
}
```

## Testing

- Integrated with cucumber and feature file is located at

```bash
src/test/resources/Feature
```

- Test case will be executed automatically during installation or with command

```bash
mvn test
```

