public class CustomHashTable {
  private static int DEFAULT_CAPACITY = 100;
  private Entry[] table;
  private int numberOfentires;
  private double LoadFactor = 0.5;

  private int hash(int key) {
    return (key * key + 8) % table.length;
  }

  public void insert(int key, Response value) {
    // Check the hash table's status, and double its size if it's nearly full
    if ((double) numberOfentires / (double) table.length > LoadFactor) {
      rehash();
    }

    // Perform the hashing operation
    Entry newEntry = new Entry(key, value);
    int index = hash(key);

    // Use linear probing to deal with collisions
    while (table[index] != null && table[index].getKey() != key) {
      index = (index + 1) % table.length;
    }

    // If the position is empty, insert the entry on it
    // If it's not empty, it's the same key, so the value of the key needs to be updated
    if (table[index] == null) {
      table[index] = newEntry;
      numberOfentires++;
    } else {
      table[index] = newEntry;
    }
  }

  public Response search(int key) {
    // Same logic to find the position of the key
    int index = hash(key);
    while (table[index] != null && table[index].getKey() != key) {
      index = (index + 1) % table.length;
    }

    // Perform searching
    if (table[index] == null) {
      System.out.println("Key not in table.");
      return null;
    } else {
      return table[index].getValue();
    }
  }

  public void delete(int key) {
    // Same logic to find the position of the key
    int index = hash(key);
    while (table[index] != null && table[index].getKey() != key) {
      index = (index + 1) % table.length;
    }

    // Perform deleting
    if (table[index].getKey() == key) {
      table[index] = null;
      numberOfentires--;
    } else {
      System.out.println("No such entry.");
    }
  }

  public void printHT() {
    for (int i = 0; i < table.length; i++) {
      if (table[i] == null) {
        System.out.println("null");
      } else {
        System.out.println("(" + table[i].getKey() + ",");
        table[i].getValue().printResponse();
        System.out.println(")");
      }
    }
  }

  public CustomHashTable() {
    this.table = new Entry[DEFAULT_CAPACITY];
    this.numberOfentires = 0;
  }

  private void rehash() {
    // Double the table length
    Entry[] oldTable = table;
    int newCapacity = table.length * 2;
    table = new Entry[newCapacity];
    numberOfentires = 0;

    // Insert entries from the old table to the new table
    for (Entry entry : oldTable) {
      if (entry != null) {
        insert(entry.getKey(), entry.getValue());
      }
    }
  }

  public static class Entry {
    private final int key;
    private Response value;

    public Entry(int key, Response value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public Response getValue() {
      return value;
    }
  }

  public static Entry createEntry(int key, Response value) {
    return new Entry(key, value);
  }

  public Entry[] getTable() {
    return this.table;
  }

  public static void main(String[] args) {
    CustomHashTable myTable = new CustomHashTable();
  }
}
