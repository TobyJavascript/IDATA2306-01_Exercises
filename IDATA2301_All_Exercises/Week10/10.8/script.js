// Select elements
const paragraph = document.getElementById("text");
const addButton = document.getElementById("addClass");
const removeButton = document.getElementById("removeClass");

// Add class on button click
addButton.addEventListener("click", () => {
    paragraph.classList.add("yellow");
});

// Remove class on button click
removeButton.addEventListener("click", () => {
    paragraph.classList.remove("yellow");
});
