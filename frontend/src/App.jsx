import { useEffect, useState } from 'react';

function App() {
  const [books, setBooks] = useState([]);
  const [title, setTitle] = useState('');
  const [isbn, setIsbn] = useState('');
  const [author, setAuthor] = useState('');
  const [genre, setGenre] = useState('');


    
    const loadBooks = async () => {
      try {
        const response = await fetch('/api/books');
        const data = await response.json();

        console.log(data);
        setBooks(data);
      } catch (error) {
        console.error(error);
      }
    };
  
  useEffect(() => {
    loadBooks();
  }, []);

  const submitForm = async (e) => {
    e.preventDefault();

    const book = {
      title,
      isbn, 
      author,
      genre,
      available: true
    };

    try {
      const response = await fetch('/api/books', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)
      });

      await loadBooks();

      const savedBook = await response.json();
      console.log('Book added', savedBook);

      setTitle('');
      setIsbn('');
      setAuthor('');
      setGenre('');
      
    } catch (error) {
      console.error("Error adding book:", error);
    }
  };

  return (
    
    <div>
      <div>
        <h1>Add Book</h1>

        <form onSubmit={submitForm}>

          <div>
            <label>Title:</label>
            <input 
              type="text"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              required
            />
          </div>

          <div>
            <label>ISBN</label>
            <input 
              type="text"
              value={isbn}
              onChange={(e) => setIsbn(e.target.value)}
              required
            />
          </div>

          <div>
            <label>Author</label>
            <input 
              type="text"
              value={author}
              onChange={(e) => setAuthor(e.target.value)}
              required
            />
          </div>

          <div>
            <label>Genre</label>
            <input 
              type="text"
              value={genre}
              onChange={(e) => setGenre(e.target.value)}
              required
            />
          </div>

          <button type="submit">Add Book</button>
        </form>
      </div>
      <h1>Books</h1>

      {books.map(book => (
        <div key={book.id}>
          <h3>{book.title}</h3>
          <p>Title: {book.author}</p>
          <p>ISBN: {book.isbn}</p>
          <p>Availability: {book.available ? 'Available' : 'Not Available'}</p>
          <p>Genre: {book.genre}</p>
        </div>
      ))}
    </div>
  );
}

export default App;