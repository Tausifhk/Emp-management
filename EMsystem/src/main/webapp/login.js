function updateDarkModeButton() {
    const darkModeButton = document.getElementById('darkModeButton'); 
    const isDarkMode = getDarkModePreference();

    darkModeButton.value = isDarkMode ? 'Light Mode' : 'Dark Mode';
}

window.onload = function() {
    updateDarkModeButton();
};