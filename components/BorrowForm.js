import React, { useState } from "react";

function BorrowForm({ refresh }) {

  const [form, setForm] = useState({
    name: "",
    itemName: "",
    type: "",
    date: "",
    returnDate: "",
    returned: false,
    notes: ""
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setForm({
      ...form,
      [name]: type === "checkbox" ? checked : value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    await fetch("http://localhost:8080/api/borrow", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(form)
    });

    refresh();
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Add Borrow Entry</h2>

      <input name="name" placeholder="Person Name" onChange={handleChange} />
      <br></br>
      <input name="itemName" placeholder="Item Name" onChange={handleChange} />
      <br></br>
      <input name="type" placeholder="Lend / Borrow" onChange={handleChange} />
      <br></br>
      <input type="date" name="date" onChange={handleChange} />
      <br></br>
      <input type="date" name="returnDate" onChange={handleChange} />
      <br></br>

      <label>
        Returned:
        <input type="checkbox" name="returned" onChange={handleChange} />
      </label>

      <input name="notes" placeholder="Notes" onChange={handleChange} />

      <button type="submit">Save</button>
    </form>
  );
}

export default BorrowForm;