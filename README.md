# fragment的简单封装
viewpager + fragment的架构很普遍.有时候我们需要在fragment不可见或者可见是做点什么,但是fragment的可见性不单单只有 onResume onPause ,还有setUserVisibleHint,
会不会觉得麻烦? 针对这个问题,这里简单的做了下封装
