package com.Qhodok.Stemmer;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andika
 */
public class Stemmer {
    protected HashMap word;

    public Stemmer(String[] words) {
        word = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].trim().equals("")) {
                word.put(words[i].trim(), words[i].trim());
            }
        }
    }

    public String root(String word) {
        String result = checkPrefix(word);
        if (result.equals("")) {
            result = checkSufix(word);
        } else {
            if (checkSufix(word).length() > result.length()) {
                result = checkSufix(word);
            }
        }
        return result;
    }

    protected String checkPrefix(String word) {
        String result = "";
        String temp;
        if (this.word.get(word) != null) {
            result = word;
        } else if (word.startsWith("m")) {
            temp = checkSufix("p" + word.substring(1));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            } else if (word.startsWith("me")) {
                temp = checkSufix(word.substring(2));
                if ((temp = (String) this.word.get(temp)) != null) {
                    result = temp;
                } else if (word.startsWith("meng") && word.length() > 4) {
                    if (word.substring(4).matches("k.+|g.+|h.+")) {
                        temp = checkSufix(word.substring(4));
                    } else {
                        temp = checkSufix("k" + word.substring(4));
                    }
                    if ((temp = (String) this.word.get(temp)) != null) {
                        result = temp;
                    } else if (word.startsWith("menge") && word.length() > 5) {
                        temp = checkSufix(word.substring(5));
                        if ((temp = (String) this.word.get(temp)) != null) {
                            result = temp;
                        }
                    }
                } else if (word.startsWith("meny") && word.length() > 4) {
                    if (word.substring(4).matches("s.+")) {
                        temp = checkSufix(word.substring(4));
                    } else {
                        temp = checkSufix("s" + word.substring(4));
                    }
                    if ((temp = (String) this.word.get(temp)) != null) {
                        result = temp;
                    }
                } else if (word.startsWith("mem") && word.length() > 3) {
                    if (word.substring(3).matches("b.+|f.+|v.+")) {
                        temp = checkSufix(word.substring(3));
                    } else {
                        temp = checkSufix("p" + word.substring(3));
                    }
                    if ((temp = (String) this.word.get(temp)) != null) {
                        result = temp;
                    } else if (word.startsWith("memper") && word.length() > 6) {
                        temp = checkSufix(word.substring(6));
                        if ((temp = (String) this.word.get(temp)) != null) {
                            result = temp;
                        }
                    }
                } else if (word.startsWith("men") && word.length() > 3) {
                    if (word.substring(3).matches("c.+|d.+|j.+")) {
                        temp = checkSufix(word.substring(3));
                    } else {
                        temp = checkSufix("t" + word.substring(3));
                    }
                    if ((temp = (String) this.word.get(temp)) != null) {
                        result = temp;
                    }
                }
            }
        } else if (word.startsWith("be") && word.length()>2) {
            if (word.charAt(2) != 'r') {
                temp = checkSufix(word.substring(2));
                if ((temp = (String) this.word.get(temp)) != null) {
                    result = temp;
                } else if (word.startsWith("ber")) {
                    temp = checkSufix(word.substring(3));
                    if ((temp = (String) this.word.get(temp)) != null) {
                        result = temp;
                    }
                }
            } else if (word.startsWith("ber")) {
                temp = checkSufix(word.substring(3));
                if ((temp = (String) this.word.get(temp)) != null) {
                    result = temp;
                }
            }
        } else if (word.startsWith("di")) {
            temp = checkSufix(word.substring(2));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            } else if (word.startsWith("diper")) {
                temp = checkSufix(word.substring(5));
                if ((temp = (String) this.word.get(temp)) != null) {
                    result = temp;
                }
            }
        } else if (word.startsWith("ter")) {
            temp = checkSufix(word.substring(3));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            }
        } else if (word.startsWith("per")) {
            temp = checkSufix(word.substring(3));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            }
        } else if (word.startsWith("pe")) {
            temp = checkSufix(word.substring(2));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            }
        } else if (word.startsWith("ke")) {
            temp = checkSufix(word.substring(2));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            }
        } else if (word.startsWith("se")) {
            temp = checkSufix(word.substring(2));
            if ((temp = (String) this.word.get(temp)) != null) {
                result = temp;
            } else if (word.startsWith("seber")) {
                temp = checkSufix(word.substring(5));
                if ((temp = (String) this.word.get(temp)) != null) {
                    result = temp;
                }
            }
        } else if (word.matches("bekerja|belajar|pemerkosa|pemerhati")) {
            if (word.equals("bekerja")) {
                result = "kerja";
            } else if (word.equals("belajar")) {
                result = "ajar";
            } else if (word.equals("pemerkosa")) {
                result = "perkosa";
            } else {
                result = "perhati";
            }
        }
        return result;
    }

    protected String checkSufix(String word) {
        String result = "";
        String temp = "";
        if (this.word.get(word) != null) {
            result = word;
        } else if (word.endsWith("an") && word.length() - 2 > 0) {
            if ((temp = (String) this.word.get(word.substring(0, word.length() - 2))) != null) {
                result = temp;
            } else if (word.endsWith("kan") && word.length() - 3 > 0) {
                if ((temp = (String) this.word.get(word.substring(0, word.length() - 3))) != null) {
                    result = temp;
                }
            }
        } else if (word.endsWith("lah") && word.length() - 3 > 0) {
            if ((temp = (String) this.word.get(word.substring(0, word.length() - 3))) != null) {
                result = temp;
            }
        } else if (word.endsWith("nya") && word.length() - 3 > 0) {
            if ((temp = (String) this.word.get(word.substring(0, word.length() - 3))) != null) {
                result = temp;
            } else if (word.endsWith("lahnya") && word.length() - 6 > 0) {
                if ((temp = (String) this.word.get(word.substring(0, word.length() - 6))) != null) {
                    result = temp;
                }
            } else if (word.endsWith("annya") && word.length() - 5 > 0) {
                if ((temp = (String) this.word.get(word.substring(0, word.length() - 5))) != null) {
                    result = temp;
                } else if (word.endsWith("kannya") && word.length() - 6 > 0) {
                    if ((temp = (String) this.word.get(word.substring(0, word.length() - 6))) != null) {
                        result = temp;
                    }
                }
            }
        } else if (word.endsWith("i") && word.length() - 1 > 0) {
            if ((temp = (String) this.word.get(word.substring(0, word.length() - 1))) != null) {
                result = temp;
            }
        } else if (word.endsWith("ku") && word.length() - 2 > 0) {
            if ((temp = (String) this.word.get(word.substring(0, word.length() - 2))) != null) {
                result = temp;
            }
        } else if (word.endsWith("mu") && word.length() - 2 > 0) {
            if ((temp = (String) this.word.get(word.substring(0, word.length() - 2))) != null) {
                result = temp;
            }
        }
        return result;
    }
}
