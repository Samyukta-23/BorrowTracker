import React, { useState } from "react";
import BorrowForm from "./components/BorrowForm";
import BorrowList from "./components/BorrowList";

function App() {

  const [refreshFlag, setRefreshFlag] = useState(false);

  const refresh = () => {
    setRefreshFlag(!refreshFlag);
  };

  return (
    <div>
      <h1>Borrow Tracker</h1>
      <BorrowForm refresh={refresh} />
      <BorrowList key={refreshFlag} />
    </div>
  );
}

export default App;