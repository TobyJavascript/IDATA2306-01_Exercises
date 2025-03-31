// Select elements
const colorSelect = document.getElementById("colorSelect");
const chosenColorText = document.getElementById("chosenColor");
const colorBox = document.getElementById("color-example");

// Listen for changes in the select box
colorSelect.addEventListener("change", function() {
    const selectedOption = colorSelect.options[colorSelect.selectedIndex]; // Get selected option
    const colorValue = selectedOption.value; // Get color value
    const colorName = selectedOption.text; // Get displayed color name

    // Update the text to show the selected color
    chosenColorText.textContent = colorName;

    // Change the background color of the div
    if (colorValue === "roundhouse") {
        colorBox.style.backgroundImage = "url('chuck-norris.jpg')"; // Add an image
        colorBox.style.backgroundSize = "cover";
        colorBox.style.backgroundColor = ""; // Clear solid color
    } else {
        colorBox.style.backgroundColor = colorValue;
        colorBox.style.backgroundImage = ""; // Remove image if another color is selected
    }
});
