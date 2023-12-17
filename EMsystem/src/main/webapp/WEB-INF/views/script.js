
document.addEventListener('DOMContentLoaded', function () {

    var modal = document.getElementById('myModal');
    var triggerElement = document.getElementById('openModalTrigger');

    var closeBtn = document.getElementsByClassName('close')[0];
    function openModal() {
        modal.style.display = 'block';
    }
    function closeModal() {
        modal.style.display = 'none';
    }
    triggerElement.addEventListener('click', openModal);
    closeBtn.addEventListener('click', closeModal);
    window.addEventListener('click', function (event) {
        if (event.target === modal) {
            closeModal();
        }
    });
});
