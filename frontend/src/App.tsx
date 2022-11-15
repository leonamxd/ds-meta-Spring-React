import Header from "./components/Header"
import SalesCard from "./components/SalesCard"


function App() {
  return(
    <>
    <Header />
    <main>
      <section>
        <div className="dsmeta-container">
          <SalesCard />
        </div>
      </section>
    </main>
    </>
  )
}

export default App
