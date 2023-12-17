  function toggleDarkMode() {
        const root = document.documentElement;
        const darkModeButton = document.querySelector('.toggle-btn');

        root.classList.toggle("dark-mode");

        if (root.classList.contains("dark-mode")) {
            root.style.setProperty('--secondary-color', '#1c1c1c');
            darkModeButton.value = "Light Mode";
            localStorage.setItem('darkMode', 'true');
        } else {
            root.style.setProperty('--secondary-color', '#ffffff');
            darkModeButton.value = "Dark Mode";
        }
    }
  function setDarkModePreference(isDarkMode) {
    try {
        localStorage.setItem('darkMode', isDarkMode);
        console.log('Dark mode preference saved successfully.');
    } catch (error) {
        console.error('Error saving dark mode preference:', error);
    }
}
