// aniaciones para los elementos toast
window.onload = async function() {
    let toast = document.getElementById('toast');
    if (toast) {
        await new Promise(resolve => {
            setTimeout(() => {
                toast.classList.add('fade-in');
                resolve();
            }, 2000)
        });

        await new Promise(resolve => {
            setTimeout(() => {
                toast.classList.remove('fade-in');
                toast.classList.add('fade-out');
                resolve();
            }, 5000)
        });
    }
}

// Función para validar si un campo es numérico
function validarCampoNumerico(input) {
    const valor = input.value;
    
    if (isNaN(valor)) {
        input.setCustomValidity("Debe ingresar un valor numérico");
    } else {
        input.setCustomValidity(""); 
    }
    input.reportValidity();
}

// Función para validar si un valor es numérico
function validarNumero(valor) {
    return !isNaN(valor);
}

// Función para validar campos requeridos
function validarCamposRequeridos() {
    const requiredElements = document.querySelectorAll('[required]');
    console.log('validarCamposRequeridos');
    let hayCamposVacios = false;

    // Iterar sobre los elementos y verificar si están vacíos
    for (var i = 0; i < requiredElements.length; i++) {
        if (requiredElements[i].value.trim() === '') {
            hayCamposVacios = true;
            // Puedes realizar acciones adicionales, como resaltar el campo vacío
            requiredElements[i].style.border = '2px solid var(--color-important)';
        } else {
            requiredElements[i].style.border = '';
        }
    }

    if (hayCamposVacios) {
        alert('Por favor, complete todos los campos obligatorios.');
        return false;
    }
    
    return true;
}

