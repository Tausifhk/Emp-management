 function validateForm() {
        resetErrors();

        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const mobile = document.getElementById('mobile').value;
        const city = document.getElementById('city').value;
        const department = document.getElementById('department').value;
        const designation = document.getElementById('designation').value;
        const date = document.getElementById('date').value;
        const salary = document.getElementById('salary').value;

        validateName(name);
        validateEmail(email);
        validateMobile(mobile);
        validateCity(city);
        validateDepartment(department);
        validateDesignation(designation);
        validateDate(date);
        validateSalary(salary);

    }

    function validateName(name) {
        if (name.trim() === '') {
            document.getElementById('nameError').innerText = 'Name is required';
        }
    }

    function validateEmail(email) {
        if (email.trim() === '') {
            document.getElementById('emailError').innerText = 'Email is required';
        }
    }

    function validateMobile(mobile) {
        const mobileRegex = /^[6-9]\d{9}$/; 
        if (!mobileRegex.test(mobile)) {
            document.getElementById('mobileError').innerText = 'Invalid mobile number';
            return false;
        }

        return true;
    }
    function validateCity(city) {
        if (city.trim() === '') {
            document.getElementById('cityError').innerText = 'City is required';
        }
    }

    function validateDepartment(department) {
        if (department.trim() === '') {
            document.getElementById('departmentError').innerText = 'Department is required';
        }
    }

    function validateDesignation(designation) {
        if (designation.trim() === '') {
            document.getElementById('designationError').innerText = 'Designation is required';
        }
    }

   function validateDate(date) {
        const currentDate = new Date();
        const inputDate = new Date(date);

        if (inputDate > currentDate) {
            document.getElementById('dateError').innerText = 'Date should be in the Past';
            return false;
        }

        return true;
    }
    function validateSalary(salary) {
        if (salary.trim() === '') {
            document.getElementById('salaryError').innerText = 'Salary is required';
        }
    }

    function resetErrors() {
        const errorMessages = document.querySelectorAll('.error-message');
        errorMessages.forEach(errorMessage => errorMessage.innerText = '');
    }