# Selenium Java JUnit Test Automation Framework

## Overview

This repository contains a UI test automation framework developed for
**learning, practicing, and demonstrating Selenium WebDriver functionalities**.

The framework is built using **Java 21, JUnit 6, and Selenium 4**.
Automated tests are implemented against the [DemoQA](https://demoqa.com/) website
to practice different browser interactions, element handling techniques, and Selenium automation capabilities.

## Technology Stack

- **Java 21** – Programming language
- **Selenium WebDriver 4** – Browser automation
- **JUnit 6** – Test execution and assertions
- **Maven** – Dependency management and build automation
- **Page Object Model (POM)** – Test framework design pattern

## Framework Features

- **Cross-browser testing:** Supports executing automated tests on different browsers.
- **Parallel execution:** Supports running tests in parallel using independent WebDriver instances.
- **Page Object Model:** Separates page interactions and locators from test logic to improve readability, reusability, and maintainability.
- **No PageFactory:** Uses Selenium `By` locators instead of `PageFactory` to locate elements dynamically, reducing the risk of `StaleElementReferenceException` caused by retaining outdated `WebElement` references.
- **Explicit waits:** Uses Selenium `WebDriverWait` and `ExpectedConditions` to handle dynamic elements and synchronization.
- **Reusable components:** Organizes common browser interactions and test functionality into reusable classes.

## Test Application

**Website:** https://demoqa.com/

The automated tests cover different Selenium WebDriver functionalities, including:

- Interacting with buttons, text fields, and other UI elements
- Handling different mouse actions
- Locating and interacting with dynamic elements
- Validating UI content and application behavior

## Purpose

This project is intended for **educational and testing purposes only**.
It serves as a practical environment for experimenting with Selenium features,
applying test automation best practices, and continuously improving framework design and implementation.
