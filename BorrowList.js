import React, { useEffect, useState } from "react";

function BorrowList() {

  const [data, setData] = useState([]);

  const fetchData = async () => {
    const response = await fetch("http://localhost:8080/api/borrow");
    const result = await response.json();
    setData(result);
  };

  const deleteItem = async (id) => {
    await fetch(`http://localhost:8080/api/borrow/${id}`, {
      method: "DELETE"
    });

    fetchData();
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <h2>Borrow History</h2>

      {data.map(item => (
        <div key={item.id} style={{border: "1px solid black", margin: "10px", padding: "10px"}}>
          <h4>{item.name} - {item.itemName}</h4>
          <p>Type: {item.type}</p>
          <p>Date: {item.date}</p>
          <p>Return Date: {item.returnDate}</p>
          <p>Returned: {item.returned ? "Yes" : "No"}</p>
          <p>Notes: {item.notes}</p>

          <button onClick={() => deleteItem(item.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}

export default BorrowList;