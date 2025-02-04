# 🍳 Sazonify

**Sazonify** is a recipe application that helps you explore, search for, and discover new culinary ideas. With features such as category searches, sorting by popularity, and personalized results, this app leverages the Spoonacular API to provide a complete culinary experience.

---

## 🚀 Features

### Home Screen:
- **Recipes by Category:** Explore recipes for breakfast, lunch, desserts, and more.
- **Popular Recipes:** Discover the most popular recipes based on Spoonacular data.
- **Quick Recipes:** Find recipes that you can prepare in 15 minutes or less.
- **Ingredient Search:** Enter the ingredients you have at home and get relevant recipes.

### Detail Screen:
- Full recipe details, including ingredients, preparation steps, and total time.

---

## 🛠️ Technologies Used

### Frontend:
- **Kotlin:** Main language for the app.
- **Jetpack Compose:** Modern declarative UI framework for Android.

### Backend/API:
- **Spoonacular API:** Recipe database.
  - [Official Documentation](https://spoonacular.com/food-api).

### Key Dependencies:
- **Retrofit:** API calls.
- **Hilt:** Dependency injection.
- **StateFlow:** Handling reactive states.

---

## 🏗️ Architecture

- **MVVM (Model-View-ViewModel):** Clear separation between business logic and UI.
- **Repository Pattern:** To handle API calls.
- **StateFlow:** To manage reactive states and real-time updates.

---

## 🔧 Setup

### Step 1: Clone this Repository
```bash
git clone https://github.com/your-username/sazonify.git
```

### Step 2: Obtain a Spoonacular API Key
1. Go to [Spoonacular API](https://spoonacular.com/food-api).
2. Sign up and log in.
3. Create a new project and copy your API key.

---
### Step 3: Configure the API Key
1. Open the `local.properties` file (create one if it doesn't exist).
2. Add your key:
   ```properties
   SPOONACULAR_API_KEY=your_api_key_here
### Step 4: Set Up Environment Variables (Optional)

If you prefer to use environment variables, follow these steps:

#### Mac/Linux:
```bash
export SPOONACULAR_API_KEY=your_api_key_here
```

#### Windows:
```cmd
set SPOONACULAR_API_KEY=your_api_key_here
```

### Step 5: Run the App

1. Open the project in Android Studio.
2. Connect a device or emulator.
3. Press **Run**.

---

## 🖼️ Screenshots

### Home Screen
[![Home Screen](https://via.placeholder.com/600x400?text=Home+Screen)](https://imgur.com/a/4VImy7I)

### Detail Screen
[![Detail Screen](https://via.placeholder.com/600x400?text=Detail+Screen)](https://imgur.com/a/7jDoizw)

### Search Screen
[![Search Screen](https://via.placeholder.com/600x400?text=Search+Screen)](https://imgur.com/a/Kqs1Z4s)

### Grocery Screen
[![Grocery Screen](https://via.placeholder.com/600x400?text=Grocery+Screen)](https://imgur.com/a/a8PpjDF)

---

## 🌟 Upcoming Features

- Save recipes as favorites.
- Dark mode.
- Automatically generated shopping list.
- Multi-language support.

---

## 📜 License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

## 🤝 Contributions

Contributions, issues, and feature requests are welcome! To contribute:

1. Fork the project.
2. Create a new branch:
   ```bash
   git checkout -b my-new-feature
   ```
3. Make your changes and commit:
   ```bash
   git commit -m 'Add new feature'
   ```
4. Push your changes to your fork:
   ```bash
   git push origin my-new-feature
   ```
5. Create a Pull Request.

---

## ✨ Credits

- **API:** [Spoonacular API](https://spoonacular.com/food-api)
- **Developer:** Fernando González




