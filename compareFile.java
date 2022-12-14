public class compareFile {
  String[] text;

  public compareFile(String[] t) {
    this.text = t;
  }

  // KMP
  public boolean evaluar(String[] file) {
    int M = text.length;
    int N = file.length;

    // create lps[] that will hold the longest
    // prefix suffix values for pattern
    int lps[] = new int[M];
    int j = 0; // index for pat[]

    // Preprocess the pattern (calculate lps[] array)
    computeLPSArray(text, M, lps);

    int i = 0; // index for txt[]
    while ((N - i) >= (M - j)) {
      if (text[j].equalsIgnoreCase(file[i])) {
          j++;
          i++;
      }
      if (j == M) {
          System.out.println("Found pattern at index " + (i - j));
          j = lps[j - 1];
          return true;
      }

      // mismatch after j matches
      else if (i < N && !(text[j].equalsIgnoreCase(file[i]))) {
          // Do not match lps[0..lps[j-1]] characters,
          // they will match anyway
          if (j != 0)
              j = lps[j - 1];
          else
              i = i + 1;
      }
    }
    System.out.println("Pattern not found");
    return false;
  }

  void computeLPSArray(String[] pat, int M, int lps[])
  {
      // length of the previous longest prefix suffix
      int len = 0;
      int i = 1;
      lps[0] = 0; // lps[0] is always 0

      // the loop calculates lps[i] for i = 1 to M-1
      while (i < M) {
          if (pat[i].equalsIgnoreCase(pat[len])) {
              len++;
              lps[i] = len;
              i++;
          }
          else // (pat[i] != pat[len])
          {
              // This is tricky. Consider the example.
              // AAACAAAA and i = 7. The idea is similar
              // to search step.
              if (len != 0) {
                  len = lps[len - 1];

                  // Also, note that we do not increment
                  // i here
              }
              else // if (len == 0)
              {
                  lps[i] = len;
                  i++;
              }
          }
      }
  }
}
