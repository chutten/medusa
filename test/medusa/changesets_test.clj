(ns medusa.changesets-test
  (:require [clojure.test :refer :all]
            [clj.medusa.changesets :refer [bounding-buildids]]))

(deftest bounding-buildids-single
  (testing "bounding-buildids when there is only one buildid for the day"
    (is (= (bounding-buildids "2017-08-02" "mozilla-central") ["20170802100302" "20170802100302"]))))

(deftest bounding-buildids-multiple
  (testing "bounding-buildids when there are multiple buildids for the day"
    (is (= (bounding-buildids "2017-09-18" "mozilla-central") ["20170918100059" "20170918220054"]))))

(deftest buildid-from-dir
  (is (= (#'clj.medusa.changesets/buildid-from-dir "2017-09-21-10-01-41-mozilla-central/") "20170921100141")))
