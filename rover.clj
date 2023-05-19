(def left {:N :W
           :W :S
           :S :E
           :E :N})

(def right {:N :E 
            :E :S
            :S :W
            :W :N})

(def delta {:N [0 1] 
            :E [1 0] 
            :S [0 -1] 
            :W [-1 0]})

(defn spin-left [rover]
  (assoc rover :direction ((:direction rover) left)))

(defn spin-right [rover]
  (assoc rover :direction ((:direction rover) right)))

(defn move [rover]
  (assoc rover :position (map + (:position rover) ((:direction rover) delta))))

(defn instruct-rover [rover instruction] 
  (case instruction
    \L (spin-left rover)
    \R (spin-right rover)
    \M (move rover)
    (do (println "Invalid input!!!")
        rover) ))

(instruct-rover {:position [0 0]
                 :direction :N} \O)

(reduce instruct-rover {:position [0 0] :direction :N} "MRMLMO")