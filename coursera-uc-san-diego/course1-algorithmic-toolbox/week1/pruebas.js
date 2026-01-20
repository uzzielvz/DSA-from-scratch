// Dishes Data
const dishData = [
    { name: "Italian pasta", price: 9.55 },
    { name: "Rice with veggies", price: 8.65 },
    { name: "Chicken with potatoes", price: 15.55 },
    { name: "Vegetarian Pizza", price: 6.45 },
];

// Tax Value
const tax = 1.20;

// Task 1: Implement getPrices()
function getPrices(taxBoolean) {
    // WRITE YOUR CODE HERE
    for (const dish of dishData) {
        let finalPrice;
        if (taxBoolean) {
            finalPrice = dish.price * tax;
        } else if (!taxBoolean) {
            finalPrice = dish.price;
        } else {
            console.log("You need to pass a boolean to the getPrices call!");
            return;
        }
        console.log(`Dish: ${dish.name} Price: ${finalPrice}`);
    }
}

// Task 2: Implement getDiscount()
function getDiscount(taxBoolean, guests) {
    // WRITE YOUR CODE HERE
}

// Call getDiscount() with sample arguments
getDiscount(true, 2);
getDiscount(false, 10);