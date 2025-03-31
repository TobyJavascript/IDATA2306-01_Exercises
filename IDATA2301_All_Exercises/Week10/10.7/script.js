// Function to set text inside the grid
function markGrid() {
    // Select all divs inside the grid
    let gridItems = document.querySelectorAll(".grid div");

    // Loop through each div and set text based on its class
    gridItems.forEach(div => {
        if (div.classList.contains("odd")) {
            div.textContent = "X";
        } else if (div.classList.contains("even")) {
            div.textContent = "O";
        }
    });
}

// Run function when page loads
window.onload = markGrid;
