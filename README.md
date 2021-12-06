# bankingledgerdemo
This is a backend service to support customers to handle their account ledgers 

## Build
    gradlew clean build

## Test
    1. unit test
        gradlew test
    2. integration test
        gradlew integrationTest

## Coverage Report
    1. jacoco
        command : gradlew jacocoTestReport
        reports : [xml] jacoco\xml\jacoco.xml
                  [html] jacoco\coverage\test\html\index.html
    2. sonar
        gradlew sonar -Dsonar.verbose=true -Dsonar.projectName=bankingledgerdemo -Dsonar.projectKey=bankingledgerdemo -Dsonar.coverage.jacoco.xmlReportPaths=build/jacoco/xml/jacoco.xml
        project : bankingledgerdemo

### Generate Reports
    1. jacoco dump
        command : gradleW -PjmxHost="host" -PjmxPort="jmxPORT"
    2. jacoco report
        command : ATJacocoTestReport
        reports : [xml] jacoco\xml\jacoco-at.xml
                  [html] jacoco\coverage\automation\html\index.html
    3. sonar
        gradlew sonar -Dsonar.verbose=true -Dsonar.projectName=bankingledgerdemo-automation -Dsonar.projectKey=bankingledgerdemo-automation -Dsonar.coverage.jacoco.xmlReportPaths=build/jacoco/xml/jacoco-at.xml
        project : bankingledgerdemo-automation

    
