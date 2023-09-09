// Initialize an empty array to store the data
const dataArray = [];
const completeTaskArray = [];
// Function to add data to the array
function addData() {
  const inputTitle = document.getElementById("title").value;
  const inputDesc = document.getElementById("Description").value;

  if (inputTitle.trim() !== "") {
    dataArray.push({ title: inputTitle, description: inputDesc });
    document.getElementById("title").value = ""; // Clear the input field
    document.getElementById("Description").value = "";
  } else {
    document.getElementById("title").value = ""; // Clear the input field
    document.getElementById("Description").value = "";
  }
  displayData();
}

// Function to display the array in the console
function displayData() {
  const tbody = document.getElementById("show-pending-tasks");
  tbody.innerHTML = ""; // Clear the table body

  dataArray.forEach((data, index) => {
    const row = document.createElement("ul");
    row.innerHTML = `
            <li class="item-1">${index + 1}</li>
            <li class="item-2">${data.title}</li>
            <li class="item-3">${data.description}</li>
            <li class="item-4">
            <span class="material-symbols-outlined" style="color: green;" onclick="completeTask(${index}); deleteTask(${index});">done</span>

              <span class="material-symbols-outlined" style="color: orange;" onclick="editTask(${index})">edit</span>
            <span class="material-symbols-outlined" style="color: red;" onclick="deleteTask(${index})">delete</span></li>
        `;
    tbody.appendChild(row);
  });
}

function deleteTask(index) {
  dataArray.splice(index, 1);
  displayData();
}
function editTask(index){
  const data = dataArray[index];
  document.getElementById("title").value = data.title;
  document.getElementById("Description").value = data.description;
  dataArray.splice(index, 1);
  displayData();
}

//completeTaskArray complete tasks store in this array

function completeTask(index) {
  const taskToComplete = dataArray[index];
  completeTaskArray.push(taskToComplete);

  displayCompleteData();
}

function displayCompleteData() {
  const complete = document.getElementById("show-complete-tasks");
  complete.innerHTML = "";

  completeTaskArray.forEach((data, index) => {
    const row = document.createElement("ul");
    row.innerHTML = `<li class="item-1">${index + 1}</li>
    <li class="item-2">${data.title}</li>
    <li class="item-3">${data.description}</li>
    <li class="item-4">
      
    <span class="material-symbols-outlined" style="color: red;" onclick="deleteCompleteTask(${index})">delete</span></li>`;

    complete.append(row);
  });
}
function deleteCompleteTask(index) {
  completeTaskArray.splice(index, 1);
  displayCompleteData();
  tbody.appendChild(row);
}
