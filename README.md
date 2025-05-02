# Instagram Unfollowers Checker

A simple Java tool that compares your Instagram **followers** and **following** lists to find out who doesn't follow you back.

## 📦 Features

- Parses Instagram data export JSON files  
- Outputs a list of users you follow who don't follow you back  
- Built using Java and Maven  
- Runs from the command line or from your IDE  

## 🚀 Getting Started

### 1. Clone the Repository

```bash
    git clone https://github.com/yourusername/instagram-unfollowers-checker.git
    cd instagram-unfollowers-checker
```

### 2. Add Your Instagram JSON Files

Download your Instagram data [here](https://accountscenter.instagram.com/info_and_permissions/)
Extract the `.zip` and place:

- `followers.json` in `src/main/resources/`  
- `following.json` (contains `relationships_following`) in `src/main/resources/`  

### 3. Run the App

Make sure you have Maven and Java 11+ installed.
```bash
    mvn compile
    mvn exec:java
```

### 4. Output

The app will print:
```python-repl
People you follow who don't follow you back:
username1
username2
...
```

## 🧰 Tech Stack

- Java 11+  
- Maven  
- org.json library  

## 📁 Project Structure
```pgsql
src/
├── main/
│   ├── java/
│   │   └── InstagramChecker.java
│   └── resources/
│       ├── followers.json
│       └── following.json
```
## 📝 License

MIT License - feel free to use, modify, and share!

## ❤️ Credits

Created by Blessed Fobkoh  
Based on Instagram's data export structure as of 2025.
