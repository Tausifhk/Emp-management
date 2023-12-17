window.onload = function() {
    const pageBody = document.body;
	const root = document.documentElement;
    function isDarkMode() {
        const darkModePreference = localStorage.getItem('darkMode');

        return darkModePreference === 'true';
    }

    if (isDarkMode()) {
        pageBody.classList.add('dark-mode');
         root.style.setProperty('--secondary-color', '#1c1c1c');
    } else {
        pageBody.classList.remove('dark-mode');
         root.style.setProperty('--secondary-color', '#fff');
    }
};