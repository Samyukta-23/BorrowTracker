import React, { useState, useEffect } from "react";
import BorrowForm from "./components/BorrowForm";
import BorrowList from "./components/BorrowList";
import Login from "./components/Login";
import Register from "./components/Register";

function App() {

  const [loggedIn, setLoggedIn] = useState(false);
  const [showRegister, setShowRegister] = useState(false);

  useEffect(() => {
    const status = localStorage.getItem("loggedIn");
    if (status === "true") {
      setLoggedIn(true);
    }
  }, []);

  const logout = () => {
    localStorage.removeItem("loggedIn");
    setLoggedIn(false);
  };

  if (!loggedIn) {
    if (showRegister) {
      return <Register switchToLogin={() => setShowRegister(false)} />;
    }
    return (
      <Login
        setLoggedIn={setLoggedIn}
        switchToRegister={() => setShowRegister(true)}
      />
    );
  }

  return (
    <div>
      <h1>Borrow Tracker</h1>
      <button onClick={logout}>Logout</button>
      <BorrowForm refresh={() => window.location.reload()} />
      <BorrowList />
    </div>
  );
}

export default App;