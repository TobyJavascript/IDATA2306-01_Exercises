// Function to initialize page when it loads
function initializePage() {
    // Change paragraph text when page loads
    document.getElementById("status-text").textContent = "Hello";

    // Start the timer
    startTimer();

    // Set up event listeners for calculator
    document.getElementById("inputA").addEventListener("input", updateResult);
    document.getElementById("inputB").addEventListener("input", updateResult);

    // Initialize calculation on load
    updateResult();
}

// Timer function
let secondsElapsed = 0;
function startTimer() {
    setInterval(() => {
        secondsElapsed++;
        document.getElementById("timer-text").textContent = `${secondsElapsed} seconds have passed since the page was loaded.`;
    }, 1000);
}

// Function to update multiplication result
function updateResult() {
    let a = document.getElementById("inputA").value;
    let b = document.getElementById("inputB").value;
    let resultDisplay = document.getElementById("result");

    // Convert to numbers
    let numA = parseFloat(a);
    let numB = parseFloat(b);

    // Check if both are valid numbers
    if (!isNaN(numA) && !isNaN(numB)) {
        resultDisplay.textContent = numA * numB;
    } else {
        resultDisplay.textContent = "Not a number!";
    }
}
